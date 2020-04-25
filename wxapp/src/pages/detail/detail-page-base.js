import { View } from '@tarojs/components'
import ShortcutsCard from '@/components/navigation/shortcuts-card'

import Listof from '@/listof/listof'
import classNames from 'classnames'
import { AtButton } from 'taro-ui'
import NavigationService from '@/nice-router/navigation.service'
import SectionBar from '@/components/section-bar/section-bar'
import { usePageTitle, usePullDown } from '@/service/use.service'

import BasePage from '@/components/base-page'
import './styles.scss'
import PropItem from './prop-item'

const SHOW_AS_MULTIPLE_LINE = ['image', 'image-list']

function DetailPageBase(props) {
  const { pageTitle } = props
  usePageTitle(pageTitle)
  usePullDown(props)

  const { propList, actionList, sectionList, footerActionList } = props

  const handleClick = (action, id) => {
    NavigationService.view(action, { id })
  }

  const commonPropsClass = classNames('common-props', { hasSection: sectionList.length > 0 })
  return (
    <BasePage>
      <View className='detail-page'>
        {actionList.length > 0 && (
          <View className='action-bar'>
            <ShortcutsCard list={actionList} title='常用功能' />
          </View>
        )}

        <View className={commonPropsClass}>
          {propList.map((schema) => {
            const { id, type, label, fieldName } = schema
            const multiLine = SHOW_AS_MULTIPLE_LINE.includes(type)
            const rootCls = classNames('common-props-item', { inline: !multiLine })
            let item = props[fieldName]
            return (
              <View key={id} className={rootCls}>
                <View className='common-props-item-label'>{label}</View>
                <PropItem type={type} item={item} schema={schema} />
              </View>
            )
          })}
        </View>

        {sectionList.map((section) => {
          const { id, title, linkToUrl, brief, displayMode } = section
          const list = props[id] || []
          return (
            <View key={`${id}_${title}`}>
              <View className='section-list'>
                <SectionBar title={title} brief={brief} linkToUrl={linkToUrl} />
              </View>
              <Listof list={list} displayMode={displayMode} />
            </View>
          )
        })}

        {footerActionList && (
          <View className='footer-button'>
            {footerActionList.map((it) => {
              const { id, code, title } = it
              return (
                <View key={id + code} className='footer-button-btn'>
                  <AtButton type='primary' onClick={handleClick.bind(this, it)}>
                    {title}
                  </AtButton>
                </View>
              )
            })}
          </View>
        )}
      </View>
    </BasePage>
  )
}

DetailPageBase.defaultProps = {
  propList: [],
  actionList: [],
  sectionList: [],
  footerActionList: [],
}

export default DetailPageBase
