import { AtGrid, AtSearchBar, AtTag } from 'taro-ui'
import classNames from 'classnames'
import trim from 'lodash/trim'
import { View } from '@tarojs/components'
import ShortcutsCard from '@/components/navigation/shortcuts-card'
import { connect } from '@tarojs/redux'
import groupBy from 'lodash/groupBy'
import forEach from 'lodash/forEach'
import { useAsyncEffect, useAsyncState, usePageTitle, usePullDown } from '@/service/use.service'
import NavigationService from '@/nice-router/navigation.service'
import Config from '@/utils/config'
import './styles.scss'

function ServiceCenterPage(props) {
  const [keyword, setKeyword] = useAsyncState('')
  const [searchHistory, setSearchHistory] = useAsyncState([])

  const { pageTitle } = props
  usePageTitle(pageTitle)
  usePullDown(Config.api.FooterServiceCenter)

  useAsyncEffect(() => {
    NavigationService.view(Config.api.FooterServiceCenter)
  }, [])

  const handleKeywordSearch = ({ keyword: value }) => setKeyword(value)

  const onSearchActionClick = () => {
    console.log('开始搜索')
    const txt = trim(keyword)
    const notInSearchHistory = searchHistory.findIndex((it) => it.keyword === txt) === -1
    if (notInSearchHistory) {
      const list = [{ id: Date.now(), keyword: txt }].concat(searchHistory.slice(0, 5))
      setSearchHistory(list)
    }
  }

  const handleClick = (action) => {
    NavigationService.view(action)
  }

  const { actionList = [], sectionList = [] } = props
  const historyCls = classNames('search-bar-history', {
    // 'space-around': searchHistory.length === 4,
  })

  const serviceGroup = groupBy(sectionList, 'viewGroup')
  const serviceGroupList = []

  forEach(serviceGroup, (serviceList, groupName = '') => {
    const gridData = serviceList.map((it) => {
      return {
        ...it,
        value: it.title,
        image: it.icon || it.imageUrl,
      }
    })

    const name = groupName === '__no_group' ? '菜单' : groupName
    serviceGroupList.push({
      id: name,
      name,
      gridData,
    })
  })

  return (
    <View className='service-center-page'>
      <View className='search-bar'>
        <AtSearchBar actionName='搜一下' value={keyword} onChange={setKeyword} onActionClick={onSearchActionClick} />

        {searchHistory.length > 0 && (
          <View className={historyCls}>
            {searchHistory.map((it) => {
              const { id } = it
              return (
                <AtTag
                  key={id}
                  className='search-bar-history-keyword'
                  active
                  onClick={handleKeywordSearch.bind(this, it)}
                >
                  {it.keyword}
                </AtTag>
              )
            })}
          </View>
        )}
      </View>

      {actionList.length > 0 && (
        <View className='change-request-bar'>
          <ShortcutsCard list={actionList} title='常用功能' />
        </View>
      )}

      {serviceGroupList.map((it) => {
        const { id, name, gridData } = it
        return (
          <View className='view-group' key={id}>
            <View className='view-group-title'>{name}</View>
            <View className='grid-container'>
              <AtGrid mode='square' className='service-grid' data={gridData} onClick={handleClick} />
            </View>
          </View>
        )
      })}
    </View>
  )
}

ServiceCenterPage.options = {
  addGlobalClass: true,
}

export default connect(({ serviceCenter }) => ({ ...serviceCenter }))(ServiceCenterPage)

// const defaultShortcutsList = [
//   {
//     code: 'FINE_DECORATION',
//     icon: buildingIcon,
//     title: '发起申请',
//   },
//   {
//     code: 'BIZ_CHAIN',
//     icon: commerceIcon,
//     title: '我发起',
//   },
// ]
