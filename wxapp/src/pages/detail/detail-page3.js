import { connect } from '@tarojs/redux'
import DetailPageBase from './detail-page-base'

const AbsPage = (props) => <DetailPageBase {...props} />

export default connect(({ detail3 }) => ({ ...detail3 }))(AbsPage)
