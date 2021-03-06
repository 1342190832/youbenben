import { View } from '@tarojs/components'
import PropTypes from 'prop-types'
import { AtDrawer, AtIcon } from 'taro-ui'
import classNames from 'classnames'
import { useVisible } from '@/service/use.service'
import { isEmpty, noop } from '@/nice-router/nice-router-util'

import './filter-bar.scss'
import { useFacet, useFilterTabs } from './filter.use'

const DEFAULT_CODE_4_MAIN = 'main'

function FilterBar(props) {
  const { title, items, facetList, max, onChange } = props
  const { pinFirst, bordered } = props
  const asATabBar = isEmpty(facetList)

  // filter
  const { tabs, activeTabs, setSelected, selected } = useFilterTabs(items, max, pinFirst)
  const { facetGroup, selectedFacet, setSelectedFacet, onFacetChange } = useFacet(
    tabs,
    title,
    DEFAULT_CODE_4_MAIN,
    facetList,
  )

  const { visible, show, close } = useVisible(false)

  const onTabClick = (item) => {
    setSelected(item)
    clearFacetCondition()
    onChange(item)
  }

  const handleFacetSelect = (item, facetCode) => {
    if (facetCode === DEFAULT_CODE_4_MAIN) {
      setSelected(item)
      if (asATabBar) {
        close()
      }
      return
    }
    onFacetChange({ ...item, facet: facetCode })
  }

  const isFacetSelect = (item, facetCode) => {
    if (facetCode === DEFAULT_CODE_4_MAIN) {
      return selected.id === item.id
    }
    return selectedFacet.findIndex((it) => it.id === item.id) > -1
  }

  const clearFacetCondition = () => setSelectedFacet([])

  const handleConfirm = () => {
  }

  const tabsClass = classNames('filter-tabs', { bordered })

  return isEmpty(items) ? null : (
    <View>
      <View className={tabsClass}>
        {activeTabs.map((tab) => {
          const itemClass = classNames('filter-tabs-item', {
            'pin-first': pinFirst,
            selected: selected.id === tab.id,
          })
          return (
            <View key={tab.key} className={itemClass} onClick={onTabClick.bind(this, tab)}>
              {tab.name}
            </View>
          )
        })}

        <View className='filter-tabs-icon' onClick={show}>
          {visible ? <AtIcon value='chevron-up' size={20} /> : <AtIcon value='chevron-down' size={20} />}
        </View>
      </View>

      {selectedFacet.length > 0 && (
        <View className='facet-condition'>
          <View className='facet-condition-container'>
            {selectedFacet.map((it) => {
              return (
                <View key={it.id} className='facet-condition-item'>
                  <View className='facet-condition-item-txt'> {it.name}</View>
                </View>
              )
            })}
          </View>
          <View className='facet-condition-clear' onClick={clearFacetCondition}>
            全部清除
          </View>
        </View>
      )}

      <AtDrawer width='90%' show={visible} onClose={close}>
        <View className='filter-draw'>
          <View className='filter-draw-body'>
            {facetGroup.map((facet) => {
              const { list } = facet
              return (
                <View key={facet.id} className='filter-draw-group'>
                  <View className='filter-draw-group-title'>{facet.title}</View>
                  <View className='filter-draw-group-content'>
                    {list.map((item) => {
                      const { id, name } = item
                      const itemClass = classNames('filter-draw-group-content-item', {
                        selected: isFacetSelect(item, facet.code),
                      })
                      return (
                        <View key={id} className={itemClass} onClick={handleFacetSelect.bind(this, item, facet.code)}>
                          <View className='filter-draw-group-content-item-txt'>{name}</View>
                        </View>
                      )
                    })}
                  </View>
                </View>
              )
            })}
          </View>
        </View>
        <View className='filter-draw-footer' onClick={handleConfirm}>
          完成
        </View>
      </AtDrawer>
    </View>
  )
}

FilterBar.propTypes = {
  onChange: PropTypes.func,
  items: PropTypes.array,
  facetList: PropTypes.array,
  title: PropTypes.string,
  code: PropTypes.string,
  pinFirst: PropTypes.bool,
  max: PropTypes.number,
}

FilterBar.defaultProps = {
  onChange: noop,
  items: [],
  facetList: [],
  title: '',
  pinFirst: true,
  onFacetChange: noop,
  max: 4,
}

FilterBar.options = {
  addGlobalClass: true,
}

export default FilterBar
