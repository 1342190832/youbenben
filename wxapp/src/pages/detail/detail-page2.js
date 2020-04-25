import { connect } from '@tarojs/redux'
import DetailPageBase from './detail-page-base'

const AbsPage = (props) => <DetailPageBase {...props} />

export default connect(({ detail2 }) => ({ ...detail2 }))(AbsPage)
