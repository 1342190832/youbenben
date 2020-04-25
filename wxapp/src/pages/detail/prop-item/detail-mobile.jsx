import Taro from '@tarojs/taro'
import { View } from '@tarojs/components'
import './styles.scss'

function DetailMobile({ value = '' }) {
  const onClick = () => {
    Taro.makePhoneCall({ phoneNumber: value })
  }
  return (
    <View className='detail-mobile' onClick={onClick}>
      {value}
    </View>
  )
}

DetailMobile.options = {
  addGlobalClass: true,
}

export default DetailMobile
