import Taro from '@tarojs/taro'
import { AtBadge } from 'taro-ui'
import { View } from '@tarojs/components'
import NavigationService from '@/nice-router/navigation.service'
import classNames from 'classnames'
import './styles.scss'
import ActionIcon from '@/components/navigation/action-icon'

export default class ShortcutsCard extends Taro.PureComponent {
  static options = {
    addGlobalClass: true,
  }

  handleClick = (item) => {
    NavigationService.view(item)
  }

  render() {
    const { list = [], customStyle = {}, title, roundBottom = true, roundTop = true } = this.props

    if (list.length === 0) {
      return null
    }
    const rootClass = classNames('shortcuts-card', {
      'round-bottom': roundBottom,
      'round-top': roundTop,
    })

    return (
      <View className={rootClass} customStyle={customStyle}>
        {title && <View className='shortcuts-card-title'>{title}</View>}
        <View className='shortcuts-card-content'>
          {list.map((it, index) => {
            const { icon, imageUrl, title: itemTitle, badge, id } = it
            const isLast = index === list.length - 1
            return (
              <View key={id} className='shortcuts-card-item'>
                <View className='shortcuts-card-item-box' onClick={this.handleClick.bind(this, it)}>
                  <AtBadge value={badge}>
                    <ActionIcon className='shortcuts-card-item-box-image' imageUrl={imageUrl} icon={icon} />
                  </AtBadge>
                  <View className='shortcuts-card-item-box-txt'>{itemTitle}</View>
                </View>
                {!isLast && <View className='shortcuts-card-item-break' />}
              </View>
            )
          })}
        </View>
      </View>
    )
  }
}
