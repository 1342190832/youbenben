import { View } from '@tarojs/components'
import classNames from 'classnames'

import './styles.scss'

function DetailText({ value, inline = true, className }) {
  const rootClass = classNames('detail-text', className, { inline })
  return <View className={rootClass}>{value}</View>
}

DetailText.options = {
  addGlobalClass: true,
}

export default DetailText
