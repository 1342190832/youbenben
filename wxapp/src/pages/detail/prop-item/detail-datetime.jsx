import { View } from '@tarojs/components'
import { formatTime } from '@/utils/index'

import './styles.scss'

function DetailDatetime({ value, format }) {
  const displayValue = formatTime(value, format)

  return <View className='detail-datetime'>{displayValue}</View>
}

DetailDatetime.options = {
  addGlobalClass: true,
}

export default DetailDatetime
