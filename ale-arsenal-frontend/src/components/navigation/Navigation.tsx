import { Paths } from '../../paths.ts'

interface LinkProps {
	link: string
	name: string
}

const NavigationLink = (linkProps: LinkProps) => {
	return (
		<a
			className={
				'outline py-2 px-5 outline-red-400 text-white rounded m-2 focus:outline-green-500 hover:outline-blue-600'
			}
			href={linkProps.link}
		>
			{linkProps.name}
		</a>
	)
}

const Navigation = () => {
	return (
		<div
			className={
				'inline-flex max-w-md flex-col bg-black mr-10 min-h-screen py-3 pr-6'
			}
		>
			<NavigationLink link={Paths.ROOT} name={'Root'} />
			<NavigationLink link={Paths.INGREDIENT_FORM} name={'Add ingredient'} />
		</div>
	)
}

export default Navigation
