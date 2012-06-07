package sample.grails.json

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class UserController {
	def list() {
	//	render "Index called"
	render( User.findAll() as JSON )
	}
	
	def save() {
		System.out.println("Save called");
		def user = new User(request.JSON);
		//render "Create\n"
		render( user.save() as JSON )
	}
	
	def delete() {
		System.out.println("Delete called");
		def user = User.findById(params.id)
		user?.delete()
		render(user as JSON );
	}

	def edit() {
		System.out.println("Edit called");
		def user = User.findById(params.id)
		bindData(user, request.JSON)
		render(user.save() as JSON )
	}
}
