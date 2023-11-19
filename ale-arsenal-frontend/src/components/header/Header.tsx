import { Outlet } from 'react-router-dom'

import Navigation from '../navigation/Navigation.tsx'

const Header = () => (
	<div className={'flex flex-row justify-center w-1/2'}>
		<Navigation />
		<Outlet />
	</div>
)

export default Header
