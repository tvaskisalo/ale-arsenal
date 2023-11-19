import { Paths } from '../../paths.ts'

interface LinkProps {
	link: string
}

const Link = (linkProps: LinkProps) => {
	return (
		<a
			className={
				'outline py-2 px-5 outline-red-600 rounded m-2 focus:outline-green-500 hover:outline-blue-600 max-w-[30%]'
			}
			href={linkProps.link}
		>
			{linkProps.link}
		</a>
	)
}

const Navigation = () => {
	return (
		<div className={'inline-flex flex-col m-5 w-1/3'}>
			<Link link={Paths.ROOT} />
			<Link link={Paths.INGREDIENT_FORM} />
		</div>
	)
}

export default Navigation
