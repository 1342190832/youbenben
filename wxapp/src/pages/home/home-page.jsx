import { View } from '@tarojs/components'
import { connect } from '@tarojs/redux'
import EleCarousel from '@/components/elements/ele-carousel'
import ActionFloor from '@/components/navigation/action-floor'
import Config from '@/utils/config'
import SectionBar from '@/components/section-bar/section-bar'
import Listof from '@/listof/listof'
import { useAsyncEffect, usePageTitle, usePullDown } from '@/service/use.service'

import NavigationService from '@/nice-router/navigation.service'
import './home.scss'

const defaultImageUrl = 'http://www.eastphoto.cn/indexImages/ep-012136603.jpg'

function HomePage(props) {
  const { pageTitle } = props
  usePageTitle(pageTitle)
  usePullDown(Config.api.FooterHome)
  // usePageShare()
  useAsyncEffect(() => {
    NavigationService.view(Config.api.FooterHome)
  }, [])

  const { slideList = defaultSlideList, actionList = [], sectionList = defaultSectionList } = props

  return (
    <View className='home-page'>
      <EleCarousel items={slideList} height={220} />
      <View className='home-page-action-floor'>
        <ActionFloor actions={actionList} />
      </View>
      {sectionList.map((section) => {
        const { id, title, linkToUrl, brief, displayMode } = section
        const list = props[id] || []
        return (
          <View key={`${id}_${title}`} className='home-page-section'>
            <SectionBar title={title} brief={brief} linkToUrl={linkToUrl} />
            <Listof list={list} displayMode={displayMode} />
          </View>
        )
      })}
    </View>
  )
}

export default connect(({ home }) => ({ ...home }))(HomePage)

const defaultSlideList = [{ videoUrl: defaultImageUrl, imageUrl: defaultImageUrl }, { imageUrl: defaultImageUrl }]
const defaultSectionList = [{ title: '业务列表', brief: 'EnglishName', linkToUrl: './', list: [] }]
