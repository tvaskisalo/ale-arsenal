import { Outlet } from 'react-router-dom'

import { defaults } from '../../theme/defaults.ts'
import Navigation from '../navigation/Navigation.tsx'

const Header = () => (
	<div className={`flex flex-row ${defaults}`}>
		<Navigation />
		<Outlet />
	</div>
)

export default Header
