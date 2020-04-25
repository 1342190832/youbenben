import EleActionList from '@/components/elements/ele-action-list'
import { View } from '@tarojs/components'

import './styles.scss'

function DetailFile({ documentUrl }) {
  return (
    <View className='detail-file'>
      <EleActionList
        list={[
          {
            id: 'open-document',
            btnType: 'open-document',
            linkToUrl: documentUrl,
            title: '查看',
          },
          {
            id: 'download-document',
            btnType: 'download',
            linkToUrl: documentUrl,
            title: '下载',
          },
          {
            id: 'download-copy',
            btnType: 'copy',
            title: '分享',
            extraData: documentUrl,
          },
        ]}
      />
    </View>
  )
}

DetailFile.options = {
  addGlobalClass: true,
}

export default DetailFile
