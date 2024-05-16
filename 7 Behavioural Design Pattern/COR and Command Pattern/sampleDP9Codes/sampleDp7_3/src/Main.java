import cmdPattern.*;
import corPattern.AbstractHandler;
import corPattern.EngineIssueHandler;
import corPattern.PressureIssueHandler;
import corPattern.PressureIssueRequest;

public class Main {
    public static void main(String[] args) {
      //cmdPattern

        //setting up the system
        BreakMechanism breakMechanism = new BreakMechanism();
        AirSuspensionMechanism airSuspensionMechanism = new AirSuspensionMechanism();

        EngageBreakCommand breakCmd = new EngageBreakCommand(breakMechanism);
        AirSuspensionCommand airCmd = new AirSuspensionCommand(airSuspensionMechanism);

        Panel btnPanel = new Panel();

        btnPanel.setCommand(0, airCmd);
        btnPanel.setCommand(1, breakCmd);

        ///try different buttons
        //btnPanel.liftSuspension();  // Lift ho rhi hai, ohhh Wow hogyi, ohooo rukgyi
        btnPanel.applyBreak(); // Break apply ho rhi hai, ohhh Wow hogyi, ohooo rukgyi


        //corPattern
        //sabse pehle chain create kardo

//        AbstractHandler pressureHandler = new PressureIssueHandler(null); // pressureHandler  ke successor m koi nhi hai
//        EngineIssueHandler engineIssueHandler = new EngineIssueHandler(pressureHandler);
// engineIssueHandler k successor mein pressureHandler hai
//    30 and 31st line se hmne handler create krli
//
//        //request re4ady karo
//        PressureIssueRequest pressureIssueRequest = new PressureIssueRequest();
//
//        engineIssueHandler.handleRequest(pressureIssueRequest);
//  hmne pressureIssueRequest handle krne engine ko di hai prr engine handle nhi kr payega so engine pressureHandler ko de dega
// // output
// // PressureHandler is handling request

    }
}