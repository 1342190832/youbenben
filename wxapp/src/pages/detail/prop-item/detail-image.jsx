import { View } from '@tarojs/components'
import { isNotEmpty } from '@/nice-router/nice-router-util'
import Taro from '@tarojs/taro'
import ServerImage from '@/server-image/server-image'
import ImageTools from '@/server-image/image-tools'

import './styles.scss'

function DetailImage({ imageUrl }) {
  const handleImagePreview = () => {
    if (isNotEmpty(imageUrl)) {
      const url = ImageTools.getServerImagUrl(imageUrl, 'origin')
      Taro.previewImage({ urls: [url] })
    }
  }

  return (
    <View className='detail-image' onClick={handleImagePreview}>
      <ServerImage src={imageUrl} size='large' mode='widthFix' />
    </View>
  )
}

DetailImage.options = {
  addGlobalClass: true,
}

export default DetailImage
