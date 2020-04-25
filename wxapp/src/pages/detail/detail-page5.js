import { connect } from '@tarojs/redux'
import DetailPageBase from './detail-page-base'

const AbsPage = (props) => <DetailPageBase {...props} />

export default connect(({ detail5 }) => ({ ...detail5 }))(AbsPage)
