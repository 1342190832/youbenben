import DetailFile from './detail-file'
import DetailImage from './detail-image'
import DetailStatus from './detail-status'
import DetailDateTime from './detail-datetime'
import DetailObject from './detail-object'
import DetailUser from './detail-user'
import DetailText from './detail-text'
import DetailImageList from './detail-image-list'
import DetailMobile from './detail-mobile'

function PropItem({ type, item, schema }) {
  const displayMode = JSON.parse(schema.displayMode)
  const newSchema = { ...schema, displayMode }

  if (type === 'money') return <DetailText inline={false} value={item} className='detail-money' />
  if (type === 'longtext') return <DetailText inline={false} value={item} />
  if (type === 'mobile') return <DetailMobile value={item} />

  if (type === 'auto') return <DetailObject {...item} schema={newSchema} />
  if (type === 'user') return <DetailUser {...item} schema={newSchema} />

  if (type === 'status') return <DetailStatus {...item} />
  if (type === 'date') return <DetailDateTime value={item} />
  if (type === 'datetime') return <DetailDateTime value={item} format='yyyy-MM-dd HH:MM' />

  if (type === 'document') return <DetailFile documentUrl={item} />
  if (type === 'image') return <DetailImage imageUrl={item} />
  if (type === 'image-list') return <DetailImageList items={item} />
  return <DetailText value={item} />
}

PropItem.defaultProps = {
  item: {},
  schema: {
    displayMode: '{}',
  },
}

export default PropItem
