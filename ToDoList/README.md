# ToDoList Application

A simple command-line ToDoList application built in Java that allows users to manage their tasks efficiently.

## Features

- Add new tasks
- View all tasks
- Mark tasks as completed
- Delete tasks
- Persistent storage using file-based storage
- User-friendly menu-driven interface

## Project Structure

```
ToDoList/
├── src/
│   ├── App.java                 # Main application entry point
│   ├── model/
│   │   └── Task.java            # Task model class
│   ├── service/
│   │   └── TaskService.java     # Business logic for task operations
│   ├── storage/
│   │   └── TaskFileStorage.java # File-based storage implementation
│   └── ui/
│       └── Menu.java            # Command-line user interface
├── lib/                         # Dependencies (if any)
├── bin/                         # Compiled output files
└── README.md                    # This file
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Visual Studio Code with Java extensions (recommended)

## Installation and Setup

1. Clone or download the project to your local machine.
2. Open the project folder in Visual Studio Code.
3. Ensure you have the Java Extension Pack installed in VS Code.

## Running the Application

1. Open the project in VS Code.
2. Compile the project:
   - Use the built-in VS Code Java compiler or run `javac -d bin src/**/*.java` from the terminal.
3. Run the application:
   - From VS Code: Right-click on `App.java` and select "Run Java".
   - From terminal: Navigate to the project root and run `java -cp bin App`.

## Usage

The application provides a menu-driven interface:

1. **Add Task**: Enter a task description to add a new task.
2. **View Tasks**: Display all tasks with their status.
3. **Mark Task Complete**: Mark a specific task as completed.
4. **Delete Task**: Remove a task from the list.
5. **Exit**: Quit the application.

Tasks are automatically saved to a file for persistence between sessions.

## Dependencies

This project uses standard Java libraries and does not require external dependencies. All code is self-contained.

## Contributing

Feel free to fork the repository and submit pull requests for improvements or bug fixes.

## License

This project is open-source and available under the MIT License.
