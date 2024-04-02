import { useEffect, useRef } from 'react'

interface DialogProps {
	title: string
	isOpen: boolean
	onClose: () => void
	children: React.ReactNode
}

const Dialog = ({ title, isOpen, onClose, children }: DialogProps) => {
	const ref = useRef<HTMLDialogElement>(null)

	useEffect(() => {
		if (isOpen) {
			ref.current?.showModal()
			document.body.classList.add('modal-open')
		} else {
			ref.current?.close()
			document.body.classList.remove('modal-open')
		}
	}, [isOpen])

	const isClickInside = (
		event: React.MouseEvent<HTMLDialogElement>,
		element: HTMLElement,
	) => {
		const boundingRectangle = element.getBoundingClientRect()

		return (
			event.clientX > boundingRectangle.left &&
			event.clientX < boundingRectangle.right &&
			event.clientY > boundingRectangle.top &&
			event.clientY < boundingRectangle.bottom
		)
	}

	return (
		<dialog
			ref={ref}
			onCancel={onClose}
			onClick={(e) =>
				ref.current !== null && !isClickInside(e, ref.current) && onClose()
			}
			className="rounded-2xl p-6 w-2/6 h-3/6"
		>
			<h3>{title}</h3>
			{children}
			<button onClick={onClose}>Close</button>
		</dialog>
	)
}

export default Dialog
