import Taro from '@tarojs/taro'
import { Text, View } from '@tarojs/components'
import debounce from 'lodash/debounce'
import NavigationService from '@/nice-router/navigation.service'
import ServerImage from '@/server-image/server-image'
import { isNotEmpty } from '@/nice-router/nice-router-util'
import ImageTools from '@/server-image/image-tools'
import './styles.scss'

function DetailUser(props) {
  const { id, schema } = props
  const { displayMode } = schema
  const title = props[displayMode.title]
  const imageUrl = props[displayMode.imageUrl]
  const brief = props[displayMode.brief] || '牛逼'

  const onClick = debounce(() => {
    NavigationService.view(schema.linkToUrl, { id })
  }, 500)

  const onImagePreview = () => {
    const url = ImageTools.getServerImagUrl(imageUrl, 'origin')
    Taro.previewImage({ urls: [url] })
  }

  return (
    <View className='detail-user'>
      <View className='detail-user-avatar' onClick={onImagePreview}>
        <ServerImage src={imageUrl} size='middle' />
      </View>
      <View className='detail-user-content' onClick={onClick}>
        <Text className='detail-user-content-title'>{title}</Text>
        {isNotEmpty(brief) && <Text className='detail-user-content-brief'>{brief}</Text>}
      </View>
    </View>
  )
}

DetailUser.options = {
  addGlobalClass: true,
}

DetailUser.defaultProps = {
  schema: {
    displayMode: '{}',
  },
}

export default DetailUser
