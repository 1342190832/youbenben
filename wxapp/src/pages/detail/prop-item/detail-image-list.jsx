import { View } from '@tarojs/components'
import EleCarousel from '@/components/elements/ele-carousel'
import './styles.scss'

function DetailImageList({ items }) {
  return (
    <View className='detail-image-list'>
      <EleCarousel items={items} indicatorActiveColor='#5ebfff' height={240} customStyle={{ borderRadius: '10px' }} />
    </View>
  )
}

DetailImageList.options = {
  addGlobalClass: true,
}

export default DetailImageList
