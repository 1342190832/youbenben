import { View } from '@tarojs/components'
import { connect } from '@tarojs/redux'
import NavigationService from '@/nice-router/navigation.service'
import ShortcutsCard from '@/components/navigation/shortcuts-card'

import Config from '@/utils/config'
import { AtButton, AtIcon } from 'taro-ui'
import classNames from 'classnames'
import { useAsyncEffect, usePageTitle, usePullDown } from '@/service/use.service'

import ServerImage from '@/server-image/server-image'

import './me.scss'

const defaultAvatar = 'http://www.eastphoto.cn/indexImages/ep-012136603.jpg'

const defaultActionList = [
  {
    code: 'FINE_DECORATION',
    imageUrl: defaultAvatar,
    title: '发起申请',
  },
  {
    code: 'BIZ_CHAIN',
    icon: 'app-2',
    title: '我发起',
  },
]


function MePage(props) {
  const { pageTitle } = props
  usePageTitle(pageTitle)
  usePullDown(Config.api.FooterMe)
  // usePageShare()
  useAsyncEffect(() => {
    NavigationService.view(Config.api.FooterMe)
  }, [])
  const handleClick = (item) => {
    NavigationService.view(item)
  }

  const handleUpdateProfileInfo = (e) => {
    if (!e || !e.detail) {
      return
    }
    console.log('handle get user info')
    const { userInfo = {} } = e.detail
    const { nickName, avatarUrl } = userInfo
    NavigationService.ajax(Config.api.UpdateProfileInfo, {
      name: encodeURIComponent(nickName),
      avatar: encodeURIComponent(avatarUrl),
    })
  }

  const handleUpdateMobile = (e) => {
    if (!e || !e.detail) {
      return
    }
    const { encryptedData, iv } = e.detail
    NavigationService.ajax(Config.api.UpdatePhoneNumber, {
      encryptedData: encodeURIComponent(encryptedData),
      iv: encodeURIComponent(iv),
    })
  }

  const {
    actionList = defaultActionList,
    sectionList = [],
    name,
    brief,
    userLike = false,
    useMobile = false,
    avatar,
  } = props

  let userBrief = brief
  if (useMobile) {
    if (brief) {
      userBrief = `${brief} (更新)`
    } else {
      userBrief = '授权获取号码'
    }
  }

  const actionListCls = classNames('me-page-header-footer', { 'user-like': userLike })
  return (
    <View className='me-page'>
      <View className='me-page-header'>
        {userLike && (
          <View className='me-page-header-top'>
            <AtButton openType='getUserInfo' className='transparent-btn' onGetUserInfo={handleUpdateProfileInfo}>
              <View className='me-page-header-top-avatar'>
                <ServerImage size='wechat-avatar' my-class='avatar-image' src={avatar || defaultAvatar} />
              </View>
            </AtButton>

            <View className='me-page-header-top-title'>
              {name && <View className='me-page-header-top-title-name'>{name}</View>}
              <AtButton
                openType='getPhoneNumber'
                className='transparent-btn'
                onGetPhoneNumber={handleUpdateMobile}
                disabled={!useMobile}
              >
                <View className='me-page-header-top-title-brief'>{userBrief}</View>
              </AtButton>
            </View>
          </View>
        )}
        <View className={actionListCls}>
          <ShortcutsCard list={actionList} />
        </View>
      </View>

      <View className='me-page-body'>
        {sectionList.length > 0 && (
          <View className='service'>
            {sectionList.map((it) => {
              const { code } = it
              return (
                <View key={code} className='service-line' onClick={handleClick.bind(this, it)}>
                  <View className='service-line-left'>
                    <ServerImage
                      my-class='service-line-left-image'
                      mode='widthFix'
                      src={it.icon || it.imageUrl || defaultAvatar}
                    />
                  </View>
                  <View className='service-line-title'>{it.title}</View>
                  <View className='service-line-right'>
                    <AtIcon size={18} value='chevron-right' />
                  </View>
                </View>
              )
            })}
          </View>
        )}
      </View>
    </View>
  )
}

export default connect(({ me }) => ({ ...me }))(MePage)
