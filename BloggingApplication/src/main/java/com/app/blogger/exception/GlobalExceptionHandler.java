package com.app.blogger.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExistException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleUserAlreadyExistException(UserAlreadyExistException exception){
		
		String errorId="UserError_01";
		String errorMessage= exception.getMessage();
		String errorDescription= errorMessage + ", " + "Login now.";
		LocalDateTime errorDate = LocalDateTime.now();
		String errorCode="400";
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errorMessage, errorDescription, errorCode, errorId, errorDate),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handlePostDoNotExistException(PostNotFoundException exception){
		
		String errorId="PostError_01";
		String errorMessage= exception.getMessage();
		String errorDescription= errorMessage ;
		LocalDateTime errorDate = LocalDateTime.now();
		String errorCode="404";
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errorMessage, errorDescription, errorCode, errorId, errorDate),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CommentNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleCommentNotFoundException(CommentNotFoundException exception){
		
		String errorId="CommentError_01";
		String errorMessage= exception.getMessage();
		String errorDescription= errorMessage ;
		LocalDateTime errorDate = LocalDateTime.now();
		String errorCode="404";
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errorMessage, errorDescription, errorCode, errorId, errorDate),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidRequestException exception){
		
		String errorId="RequestError_01";
		String errorMessage= exception.getMessage();
		String errorDescription= errorMessage ;
		LocalDateTime errorDate = LocalDateTime.now();
		String errorCode="400";
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errorMessage, errorDescription, errorCode, errorId, errorDate),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleCategoryDoNotExistException(CategoryNotFoundException exception){
		
		String errorId="CategoryError_01";
		String errorMessage= exception.getMessage();
		String errorDescription= errorMessage ;
		LocalDateTime errorDate = LocalDateTime.now();
		String errorCode="404";
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errorMessage, errorDescription, errorCode, errorId, errorDate),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception){
		
		String errorId="UserError_02";
		String errorMessage= exception.getMessage();
		String errorDescription= errorMessage ;
		LocalDateTime errorDate = LocalDateTime.now();
		String errorCode="404";
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errorMessage, errorDescription, errorCode, errorId, errorDate),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PostNotTransferableException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ResponseEntity<ErrorResponse> handlePostNotTransferableException(PostNotTransferableException exception){
		
		String errorId="PostError_03";
		String errorMessage= exception.getMessage();
		String errorDescription= errorMessage ;
		LocalDateTime errorDate = LocalDateTime.now();
		String errorCode="409";
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errorMessage, errorDescription, errorCode, errorId, errorDate),HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(InternalServerException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorResponse> handleInternalServerException(InternalServerException exception){
		
		String errorId="GenericError_01";
		String errorMessage= exception.getMessage();
		String errorDescription= errorMessage ;
		LocalDateTime errorDate = LocalDateTime.now();
		String errorCode="500";
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errorMessage, errorDescription, errorCode, errorId, errorDate),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
/**
 * 1. What is exception handling and what are its advantages?   
 * 2. Difference between an error and a exception?
 * 3. try catch finally
 * 4. What is try with Resources, example of try with resources
 * 5. How to handle multiple exception in a catch block
 * 6. Exception Propagation
 * 7. Runtime Exception (Unchecked Exception)  vs Compile Time Exception (Checked Exception) vs Error
 * 8. Methods of exception class(printStackTrace,getStackTrace)
 * 9. ClassNotFoundException vs NoClassDefFoundError(ClassNotFoundException: class not present at classpath during class loading, NoClassDefFoundError: Dependent class is compiled successfully but missing at runtime)
 * 10.Hierarchy of Exceptions
 * 11.Rules to follow 
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 																	Throwable 
 * 																	 extends
 * 												Exception										Error	
 * 													IO Exception								VirtualMachineError
 * 													Class Not Found Exception					OutOfMemoryError
 * 													SQL Exception								StackOverFlowError
 * 
 * 													Runtime Exception	
 * 															Null Pointer
 * 															IndexOutOfBound
 * 															NumberFormatException
 * 															Arithmetic Exception
 * 
 * 
 *--------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Exception handling is a programming mechanism used to handle runtime errors, or exceptions, that occur during the execution of a program. It allows a program to manage errors gracefully, rather than crashing or behaving unpredictably. By using exception handling, developers can control how errors are reported and managed, improving the robustness and user experience of an application.

Key Concepts of Exception Handling
Exception: An event that disrupts the normal flow of a program’s execution. It can be due to a variety of issues, such as invalid user input, missing files, or network errors.

Try Block: Code that might throw an exception is placed inside a try block. The try block is used to wrap code that could potentially fail.

Catch Block: A catch block is used to handle exceptions that are thrown by the try block. It specifies the type of exception it can handle and provides a way to respond to it.

Finally Block: A finally block is used for code that must execute regardless of whether an exception was thrown or not. It’s typically used for cleanup activities like closing file streams or releasing resources.

Throwing Exceptions: The throw keyword is used to explicitly throw an exception. It is commonly used in methods to indicate that something has gone wrong.

Custom Exceptions: Developers can create their own exception classes to represent specific error conditions in their applications.

Advantages of Exception Handling
Improved Error Handling:

Controlled Response: Allows for specific handling of different types of errors, rather than relying on generic error responses.
Graceful Degradation: The application can recover from errors and continue running, or provide meaningful feedback to the user.
Separation of Error Handling Code:

Clarity and Maintainability: Separates error-handling code from the regular logic, making the codebase cleaner and easier to maintain.
Focused Error Handling: Error-handling logic is centralized, improving readability and manageability of the code.
Program Stability:

Avoids Crashes: Prevents the entire application from crashing due to an unexpected condition, leading to more stable and reliable software.
Predictable Behavior: Ensures that exceptions are handled in a predictable manner, leading to more consistent application behavior.
Resource Management:

Automatic Cleanup: The finally block ensures that resources such as file handles or network connections are properly closed or released, even if an exception occurs.
Preventing Resource Leaks: Helps in managing resources effectively, reducing the risk of resource leaks.
Custom Exception Handling:

Specific Responses: Custom exceptions allow developers to define application-specific error conditions and handle them appropriately.
Improved Debugging: Custom exceptions can carry detailed information about the error, aiding in debugging and troubleshooting.
User Experience:

Graceful Error Messaging: Provides users with informative error messages or alternative actions, enhancing the overall user experience.
Recovery Options: Enables applications to offer recovery options or alternative workflows when errors occur, improving usability.
 * */
