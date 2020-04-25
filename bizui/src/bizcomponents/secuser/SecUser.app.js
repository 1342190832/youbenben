import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,Row, Col,
  Input,Button,Tooltip,
} from 'antd'

import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './SecUser.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';
import TopMenu from '../../launcher/TopMenu'
import SwitchAppMenu from '../../launcher/SwitchAppMenu'

import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
import BizAppTool from '../../common/BizApp.tool'

const { Header, Sider, Content } = Layout
const { SubMenu } = Menu
const {
  defaultFilteredNoGroupMenuItems,
  defaultFilteredMenuItemsGroup,
  defaultRenderMenuItem,

} = BizAppTool


const filteredNoGroupMenuItems = defaultFilteredNoGroupMenuItems
const filteredMenuItemsGroup = defaultFilteredMenuItemsGroup
const renderMenuItem=defaultRenderMenuItem


const naviBarResponsiveStyle = {
  xs: 10,
  sm: 10,
  md: 10,
  lg: 8,
  xl: 8,
  
};



const searchBarResponsiveStyle = {
  xs: 4,
  sm: 4,
  md: 4,
  lg: 8,
  xl: 8,
  
};

const userBarResponsiveStyle = {
  xs: 10,
  sm: 10,
  md: 10,
  lg: 8,
  xl: 8,
  
};



const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}


const currentAppName=()=>{

  const targetApp = sessionObject('targetApp')
  return targetApp.title

}


class SecUserBizApp extends React.PureComponent {
constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
      showSearch: false,
      searchKeyword:''
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/secUser/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
 getNavMenuItems = (targetObject, style, customTheme) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
    const mode =style || "inline"
    const theme = customTheme || "light" 
	const {objectId}=targetApp;
  	const userContext = null
    return (
	  <Menu
        theme="dark"
        mode="inline"
        
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/secUser/${this.props.secUser.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
           </Menu>
    )
  }
  



  getUserAppSearch = () => {
    const {UserAppSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('user_app','sec_user.user_app_list',false),
      role: "userApp",
      data: state._secUser.userAppList,
      metaInfo: state._secUser.userAppListMetaInfo,
      count: state._secUser.userAppCount,
      returnURL: `/secUser/${state._secUser.id}/dashboard`,
      currentPage: state._secUser.userAppCurrentPageNumber,
      searchFormParameters: state._secUser.userAppSearchFormParameters,
      searchParameters: {...state._secUser.searchParameters},
      expandForm: state._secUser.expandForm,
      loading: state._secUser.loading,
      partialList: state._secUser.partialList,
      owner: { type: '_secUser', id: state._secUser.id, 
      referenceName: 'secUser', 
      listName: 'userAppList', ref:state._secUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAppSearch)
  }
  
  getUserAppCreateForm = () => {
   	const {UserAppCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "userApp",
      data: state._secUser.userAppList,
      metaInfo: state._secUser.userAppListMetaInfo,
      count: state._secUser.userAppCount,
      returnURL: `/secUser/${state._secUser.id}/list`,
      currentPage: state._secUser.userAppCurrentPageNumber,
      searchFormParameters: state._secUser.userAppSearchFormParameters,
      loading: state._secUser.loading,
      owner: { type: '_secUser', id: state._secUser.id, referenceName: 'secUser', listName: 'userAppList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(UserAppCreateForm)
  }
  
  getUserAppUpdateForm = () => {
    const userContext = null
  	const {UserAppUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._secUser.selectedRows,
      role: "userApp",
      currentUpdateIndex: state._secUser.currentUpdateIndex,
      owner: { type: '_secUser', id: state._secUser.id, listName: 'userAppList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAppUpdateForm)
  }

  getLoginHistorySearch = () => {
    const {LoginHistorySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('login_history','sec_user.login_history_list',false),
      role: "loginHistory",
      data: state._secUser.loginHistoryList,
      metaInfo: state._secUser.loginHistoryListMetaInfo,
      count: state._secUser.loginHistoryCount,
      returnURL: `/secUser/${state._secUser.id}/dashboard`,
      currentPage: state._secUser.loginHistoryCurrentPageNumber,
      searchFormParameters: state._secUser.loginHistorySearchFormParameters,
      searchParameters: {...state._secUser.searchParameters},
      expandForm: state._secUser.expandForm,
      loading: state._secUser.loading,
      partialList: state._secUser.partialList,
      owner: { type: '_secUser', id: state._secUser.id, 
      referenceName: 'secUser', 
      listName: 'loginHistoryList', ref:state._secUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LoginHistorySearch)
  }
  
  getLoginHistoryCreateForm = () => {
   	const {LoginHistoryCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "loginHistory",
      data: state._secUser.loginHistoryList,
      metaInfo: state._secUser.loginHistoryListMetaInfo,
      count: state._secUser.loginHistoryCount,
      returnURL: `/secUser/${state._secUser.id}/list`,
      currentPage: state._secUser.loginHistoryCurrentPageNumber,
      searchFormParameters: state._secUser.loginHistorySearchFormParameters,
      loading: state._secUser.loading,
      owner: { type: '_secUser', id: state._secUser.id, referenceName: 'secUser', listName: 'loginHistoryList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LoginHistoryCreateForm)
  }
  
  getLoginHistoryUpdateForm = () => {
    const userContext = null
  	const {LoginHistoryUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._secUser.selectedRows,
      role: "loginHistory",
      currentUpdateIndex: state._secUser.currentUpdateIndex,
      owner: { type: '_secUser', id: state._secUser.id, listName: 'loginHistoryList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LoginHistoryUpdateForm)
  }

  getWechatWorkappIdentifySearch = () => {
    const {WechatWorkappIdentifySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('wechat_workapp_identify','sec_user.wechat_workapp_identify_list',false),
      role: "wechatWorkappIdentify",
      data: state._secUser.wechatWorkappIdentifyList,
      metaInfo: state._secUser.wechatWorkappIdentifyListMetaInfo,
      count: state._secUser.wechatWorkappIdentifyCount,
      returnURL: `/secUser/${state._secUser.id}/dashboard`,
      currentPage: state._secUser.wechatWorkappIdentifyCurrentPageNumber,
      searchFormParameters: state._secUser.wechatWorkappIdentifySearchFormParameters,
      searchParameters: {...state._secUser.searchParameters},
      expandForm: state._secUser.expandForm,
      loading: state._secUser.loading,
      partialList: state._secUser.partialList,
      owner: { type: '_secUser', id: state._secUser.id, 
      referenceName: 'secUser', 
      listName: 'wechatWorkappIdentifyList', ref:state._secUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WechatWorkappIdentifySearch)
  }
  
  getWechatWorkappIdentifyCreateForm = () => {
   	const {WechatWorkappIdentifyCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "wechatWorkappIdentify",
      data: state._secUser.wechatWorkappIdentifyList,
      metaInfo: state._secUser.wechatWorkappIdentifyListMetaInfo,
      count: state._secUser.wechatWorkappIdentifyCount,
      returnURL: `/secUser/${state._secUser.id}/list`,
      currentPage: state._secUser.wechatWorkappIdentifyCurrentPageNumber,
      searchFormParameters: state._secUser.wechatWorkappIdentifySearchFormParameters,
      loading: state._secUser.loading,
      owner: { type: '_secUser', id: state._secUser.id, referenceName: 'secUser', listName: 'wechatWorkappIdentifyList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(WechatWorkappIdentifyCreateForm)
  }
  
  getWechatWorkappIdentifyUpdateForm = () => {
    const userContext = null
  	const {WechatWorkappIdentifyUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._secUser.selectedRows,
      role: "wechatWorkappIdentify",
      currentUpdateIndex: state._secUser.currentUpdateIndex,
      owner: { type: '_secUser', id: state._secUser.id, listName: 'wechatWorkappIdentifyList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WechatWorkappIdentifyUpdateForm)
  }

  getWechatMiniappIdentifySearch = () => {
    const {WechatMiniappIdentifySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('wechat_miniapp_identify','sec_user.wechat_miniapp_identify_list',false),
      role: "wechatMiniappIdentify",
      data: state._secUser.wechatMiniappIdentifyList,
      metaInfo: state._secUser.wechatMiniappIdentifyListMetaInfo,
      count: state._secUser.wechatMiniappIdentifyCount,
      returnURL: `/secUser/${state._secUser.id}/dashboard`,
      currentPage: state._secUser.wechatMiniappIdentifyCurrentPageNumber,
      searchFormParameters: state._secUser.wechatMiniappIdentifySearchFormParameters,
      searchParameters: {...state._secUser.searchParameters},
      expandForm: state._secUser.expandForm,
      loading: state._secUser.loading,
      partialList: state._secUser.partialList,
      owner: { type: '_secUser', id: state._secUser.id, 
      referenceName: 'secUser', 
      listName: 'wechatMiniappIdentifyList', ref:state._secUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WechatMiniappIdentifySearch)
  }
  
  getWechatMiniappIdentifyCreateForm = () => {
   	const {WechatMiniappIdentifyCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "wechatMiniappIdentify",
      data: state._secUser.wechatMiniappIdentifyList,
      metaInfo: state._secUser.wechatMiniappIdentifyListMetaInfo,
      count: state._secUser.wechatMiniappIdentifyCount,
      returnURL: `/secUser/${state._secUser.id}/list`,
      currentPage: state._secUser.wechatMiniappIdentifyCurrentPageNumber,
      searchFormParameters: state._secUser.wechatMiniappIdentifySearchFormParameters,
      loading: state._secUser.loading,
      owner: { type: '_secUser', id: state._secUser.id, referenceName: 'secUser', listName: 'wechatMiniappIdentifyList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(WechatMiniappIdentifyCreateForm)
  }
  
  getWechatMiniappIdentifyUpdateForm = () => {
    const userContext = null
  	const {WechatMiniappIdentifyUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._secUser.selectedRows,
      role: "wechatMiniappIdentify",
      currentUpdateIndex: state._secUser.currentUpdateIndex,
      owner: { type: '_secUser', id: state._secUser.id, listName: 'wechatMiniappIdentifyList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WechatMiniappIdentifyUpdateForm)
  }

  getKeypairIdentifySearch = () => {
    const {KeypairIdentifySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('keypair_identify','sec_user.keypair_identify_list',false),
      role: "keypairIdentify",
      data: state._secUser.keypairIdentifyList,
      metaInfo: state._secUser.keypairIdentifyListMetaInfo,
      count: state._secUser.keypairIdentifyCount,
      returnURL: `/secUser/${state._secUser.id}/dashboard`,
      currentPage: state._secUser.keypairIdentifyCurrentPageNumber,
      searchFormParameters: state._secUser.keypairIdentifySearchFormParameters,
      searchParameters: {...state._secUser.searchParameters},
      expandForm: state._secUser.expandForm,
      loading: state._secUser.loading,
      partialList: state._secUser.partialList,
      owner: { type: '_secUser', id: state._secUser.id, 
      referenceName: 'secUser', 
      listName: 'keypairIdentifyList', ref:state._secUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(KeypairIdentifySearch)
  }
  
  getKeypairIdentifyCreateForm = () => {
   	const {KeypairIdentifyCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "keypairIdentify",
      data: state._secUser.keypairIdentifyList,
      metaInfo: state._secUser.keypairIdentifyListMetaInfo,
      count: state._secUser.keypairIdentifyCount,
      returnURL: `/secUser/${state._secUser.id}/list`,
      currentPage: state._secUser.keypairIdentifyCurrentPageNumber,
      searchFormParameters: state._secUser.keypairIdentifySearchFormParameters,
      loading: state._secUser.loading,
      owner: { type: '_secUser', id: state._secUser.id, referenceName: 'secUser', listName: 'keypairIdentifyList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(KeypairIdentifyCreateForm)
  }
  
  getKeypairIdentifyUpdateForm = () => {
    const userContext = null
  	const {KeypairIdentifyUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._secUser.selectedRows,
      role: "keypairIdentify",
      currentUpdateIndex: state._secUser.currentUpdateIndex,
      owner: { type: '_secUser', id: state._secUser.id, listName: 'keypairIdentifyList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(KeypairIdentifyUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._secUser.selectedRows,
      role: "cq",
      currentUpdateIndex: state._secUser.currentUpdateIndex,
      owner: { type: '_secUser', id: state._secUser.id, listName: 'nolist', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }
  
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '油奔奔大后台系统'
    return title
  }
 
  buildRouters = () =>{
  	const {SecUserDashboard} = GlobalComponents
  	const {SecUserPermission} = GlobalComponents
  	const {SecUserProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/secUser/:id/dashboard", component: SecUserDashboard},
  	{path:"/secUser/:id/profile", component: SecUserProfile},
  	{path:"/secUser/:id/permission", component: SecUserPermission},
  	
  	
  	
  	{path:"/secUser/:id/list/userAppList", component: this.getUserAppSearch()},
  	{path:"/secUser/:id/list/userAppCreateForm", component: this.getUserAppCreateForm()},
  	{path:"/secUser/:id/list/userAppUpdateForm", component: this.getUserAppUpdateForm()},
   	
  	{path:"/secUser/:id/list/loginHistoryList", component: this.getLoginHistorySearch()},
  	{path:"/secUser/:id/list/loginHistoryCreateForm", component: this.getLoginHistoryCreateForm()},
  	{path:"/secUser/:id/list/loginHistoryUpdateForm", component: this.getLoginHistoryUpdateForm()},
   	
  	{path:"/secUser/:id/list/wechatWorkappIdentifyList", component: this.getWechatWorkappIdentifySearch()},
  	{path:"/secUser/:id/list/wechatWorkappIdentifyCreateForm", component: this.getWechatWorkappIdentifyCreateForm()},
  	{path:"/secUser/:id/list/wechatWorkappIdentifyUpdateForm", component: this.getWechatWorkappIdentifyUpdateForm()},
   	
  	{path:"/secUser/:id/list/wechatMiniappIdentifyList", component: this.getWechatMiniappIdentifySearch()},
  	{path:"/secUser/:id/list/wechatMiniappIdentifyCreateForm", component: this.getWechatMiniappIdentifyCreateForm()},
  	{path:"/secUser/:id/list/wechatMiniappIdentifyUpdateForm", component: this.getWechatMiniappIdentifyUpdateForm()},
   	
  	{path:"/secUser/:id/list/keypairIdentifyList", component: this.getKeypairIdentifySearch()},
  	{path:"/secUser/:id/list/keypairIdentifyCreateForm", component: this.getKeypairIdentifyCreateForm()},
  	{path:"/secUser/:id/list/keypairIdentifyUpdateForm", component: this.getKeypairIdentifyUpdateForm()},
     	
 	 
  	]
  	
  	const {extraRoutesFunc} = this.props;
  	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
  	const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
   
   toggleSwitchText=()=>{
    const { collapsed } = this.props
    if(collapsed){
      return "打开菜单"
    }
    return "关闭菜单"

   }
   
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
     const userContext = null
     const renderBreadcrumbText=(value)=>{
     	if(value==null){
     		return "..."
     	}
     	if(value.length < 10){
     		return value
     	}
     
     	return value.substring(0,10)+"..."
     	
     	
     }
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const renderBreadcrumbMenuItem=(breadcrumbMenuItem)=>{

      return (
      <Menu.Item key={breadcrumbMenuItem.link}>
      <Link key={breadcrumbMenuItem.link} to={`${breadcrumbMenuItem.link}`} className={styles.breadcrumbLink}>
        <Icon type="heart" style={{marginRight:"10px",color:"red"}} />
        {renderBreadcrumbText(breadcrumbMenuItem.name)}
      </Link></Menu.Item>)

     }
     const breadcrumbMenu=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <Menu mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbMenuItem(item))}
      </Menu>)
  

     }
     const breadcrumbBar=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <div mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbBarItem(item))}
      </div>)
  

     }


	const jumpToBreadcrumbLink=(breadcrumbMenuItem)=>{
      const { dispatch} = this.props
      const {name,link} = breadcrumbMenuItem
      dispatch({ type: 'breadcrumb/jumpToLink', payload: {name, link }} )
	
     }  

	 const removeBreadcrumbLink=(breadcrumbMenuItem)=>{
      const { dispatch} = this.props
      const {link} = breadcrumbMenuItem
      dispatch({ type: 'breadcrumb/removeLink', payload: { link }} )
	
     }

     const renderBreadcrumbBarItem=(breadcrumbMenuItem)=>{

      return (
     <Tag 
      	key={breadcrumbMenuItem.link} color={breadcrumbMenuItem.selected?"#108ee9":"grey"} 
      	style={{marginRight:"1px",marginBottom:"1px"}} closable onClose={()=>removeBreadcrumbLink(breadcrumbMenuItem)} >
        <span onClick={()=>jumpToBreadcrumbLink(breadcrumbMenuItem)}>
        	{renderBreadcrumbText(breadcrumbMenuItem.name)}
        </span>
      </Tag>)

     }
     
     
     
     const { Search } = Input;
     const showSearchResult=()=>{

        this.setState({showSearch:true})

     }
     const searchChange=(evt)=>{

      this.setState({searchKeyword :evt.target.value})

    }
    const hideSearchResult=()=>{

      this.setState({showSearch:false})

    }

    const {searchLocalData}=GlobalComponents.SecUserBase
	
    const renderMenuSwitch=()=>{
      const  text = collapsed?"开启左侧菜单":"关闭左侧菜单"
      const icon = collapsed?"pic-left":"pic-center"
     
      return (

        <Tooltip placement="bottom" title={text}>
       
      
      <a  className={styles.menuLink} onClick={()=>this.toggle()} style={{marginLeft:"20px",minHeight:"20px"}}>
        <Icon type={icon} style={{marginRight:"10px"}}/> 
      </a>  </Tooltip>)

     }
     
     
       const layout = (
     <Layout>
 		<Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
          <a className={styles.menuLink}  style={{fontSize:"20px"}}>{currentAppName()}</a>
 
        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  > 
         <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释，关闭请点击搜索结果空白处" 
            enterButton onFocus={()=>showSearchResult()} onChange={(evt)=>searchChange(evt)}
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />  
          </Col>
          <Col  {...userBarResponsiveStyle}  > 
          <Row>
          <Col  span={10}  > </Col>
          <Col  span={2}  >  {renderMenuSwitch()}</Col>
          <Col  span={6}  > 
	          <Dropdown overlay={<SwitchAppMenu {...this.props} />} style={{marginRight:"100px"}} className={styles.right}>
                <a  className={styles.menuLink} >
                <Icon type="appstore" style={{marginRight:"5px"}}/>切换应用 
                </a>
              </Dropdown>
          </Col>  

          <Col  span={6}  >  
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                <Icon type="user" style={{marginRight:"5px"}}/>账户
                </a>
            </Dropdown>
            </Col>

          </Row>
            </Col>  
         </Row>
        </Header>
       <Layout style={{  marginTop: 44 }}>
        
       
       <Layout>
      
      {this.state.showSearch&&(

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.secUser,this.state.searchKeyword)}</div>

      )}
       </Layout>
        
         
         <Layout>
       <Sider
          trigger={null}
          collapsible
          collapsed={collapsed}
          breakpoint="md"
          onCollapse={() => this.onCollapse(collapsed)}
          collapsedWidth={50}
          className={styles.sider}
        >
         
         {this.getNavMenuItems(this.props.secUser,"inline","dark")}
       
        </Sider>
        
         <Layout>
         <Layout><Row type="flex" justify="start" align="bottom">{breadcrumbBar()} </Row></Layout>
        
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
           </Content>
          </Layout>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  secUser: state._secUser,
  ...state,
}))(SecUserBizApp)



