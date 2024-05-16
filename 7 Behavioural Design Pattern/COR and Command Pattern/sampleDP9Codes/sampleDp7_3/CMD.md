 Command Pattern is a behavioral design pattern used to turn a request into a stand-alone object that contains all information about the request. This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.

KEY COMPONENTS
   - Command Interface: Declares an interface for executing an operation.
   - Concrete Command: Implements the Command interface to perform specific actions by invoking methods on receiver objects.
   - Receiver: The object that performs the actual work.
   - Invoker: Asks the command to carry out the request.
   - Client: Creates a ConcreteCommand object and sets its receiver.

EXAMPLE SCENERIO
Let's consider a home automation system where you can control various devices like lights, fans, and so on.
    // Command Interface: Command interface has a single method execute that is implemented by concrete commands.
        public interface Command {
            void execute();
        }
        // 


    // Concrete Commands: LightOnCommand and LightOffCommand implement the Command interface and encapsulate the receiver (Light) and the specific request.
        // Command to turn on the light
        public class LightOnCommand implements Command {
            private Light light;

            public LightOnCommand(Light light) {
                this.light = light;
            }

            @Override
            public void execute() {
                light.on();
            }
        }

        // Command to turn off the light
        public class LightOffCommand implements Command {
            private Light light;

            public LightOffCommand(Light light) {
                this.light = light;
            }

            @Override
            public void execute() {
                light.off();
            }
        }


    // Receiver: Light class has methods to turn the light on and off.
        public class Light {
            public void on() {
                System.out.println("Light is ON");
            }

            public void off() {
                System.out.println("Light is OFF");
            }
        }


    // Invoker: RemoteControl class holds a command and calls its execute method when a button is pressed.
        public class RemoteControl {
            private Command command;

            public void setCommand(Command command) {
                this.command = command;
            }

            public void pressButton() {
                command.execute();
            }
        }


    // Client: The Client class ties it all together by creating a Light receiver, concrete command objects, and a RemoteControl invoker. The client sets the command on the invoker and triggers the command execution.
        public class Client {
            public static void main(String[] args) {
                // Create receiver
                Light livingRoomLight = new Light();

                // Create commands
                Command lightOn = new LightOnCommand(livingRoomLight);
                Command lightOff = new LightOffCommand(livingRoomLight);

                // Create invoker
                RemoteControl remote = new RemoteControl();

                // Execute commands
                remote.setCommand(lightOn);
                remote.pressButton();

                remote.setCommand(lightOff);
                remote.pressButton();
            }
        }


BENEFITS
 - Decoupling: The invoker does not need to know the details of the receiver's actions.
 - Extensibility: New commands can be added without changing existing code.
- Flexibility: Commands can be parameterized and combined.
 - Undo/Redo: Commands can store state for undo and redo functionality.

CONCLUSION
- The Command Pattern is a powerful design pattern for encapsulating all details about a request, allowing for parameterization of objects with operations, queuing of requests, and support for undoable operations. The provided Java example demonstrates how to implement this pattern in a home automation scenario.
