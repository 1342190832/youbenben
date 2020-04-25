import { Text, View } from '@tarojs/components'
import classNames from 'classnames'
import sample from 'lodash/sample'
import { isNotEmpty } from '@/nice-router/nice-router-util'

import './styles.scss'

const LEVEL = ['default', 'primary', 'normal', 'warn', 'danger']

function getLevel({ level }) {
  return level || sample(LEVEL)// sample for demo
}

function DetailStatus(props) {

  const { name, code } = props
  // const { name, code,level } = props
  const level = getLevel(props)
  const statusIconClass = classNames('detail-status-icon', { [level]: isNotEmpty(level) })

  return (
    <View className='detail-status'>
      <View className={statusIconClass} /><Text>{name} ({code})</Text>
    </View>
  )
}

DetailStatus.options = {
  addGlobalClass: true,
}

export default DetailStatus
