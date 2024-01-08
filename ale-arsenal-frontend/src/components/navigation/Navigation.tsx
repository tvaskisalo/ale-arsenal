import {NavigateFunction, useNavigate} from 'react-router-dom'

import {Paths} from '../../paths.ts'

interface LinkProps {
	path: string
	name: string
	navigate: NavigateFunction
}

const NavigationLink = ({ path, name, navigate }: LinkProps) => {
	return (
		<a
			className={
				'outline py-2 w-full px-5 outline-red-400 text-white rounded m-2 focus-visible:outline-green-500 hover:outline-blue-600 active:outline-white'
			}
			onClick={(e: React.SyntheticEvent) => {
				e.preventDefault()
				navigate(path)
			}}
			href={path}
			role="link"
		>
			{name}
		</a>
	)
}

const Navigation = () => {
	const navigate = useNavigate()
	const links = [
		{ path: Paths.ROOT, name: 'Go to main page' },
		{ path: Paths.INGREDIENT_FORM, name: 'Add ingredient' },
		{ path: Paths.OWN_BEER_FORM, name: 'Add own beer' },
	]
	return (
		<ul
			className={
				'inline-flex list-inside min-w-52 max-w-md flex-col bg-black mr-10 min-h-screen py-6 pr-6'
			}
		>
			{links.map((link) => {
				return (
					<li className={'w-[12rem] inline-flex'} key={link.path}>
						<NavigationLink
							path={link.path}
							name={link.name}
							navigate={navigate}
						/>
					</li>
				)
			})}
		</ul>
	)
}

export default Navigation
