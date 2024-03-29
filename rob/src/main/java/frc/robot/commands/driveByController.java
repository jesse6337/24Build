// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.falcon;

public class driveByController extends Command {
  /** Creates a new driveByController. */
  private XboxController xc;
  private falcon falcon;

  public driveByController(XboxController xboxdisard, falcon falcondiscard) {

    xc = xboxdisard;
    falcon = falcondiscard;
    addRequirements(falcon);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    falcon.runMotor(StickDriftOffset(xc.getLeftY(),0.08 )*200);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    falcon.zeroMotor();
  }

  private double StickDriftOffset(double input, double drift){
    double normailize = 1-drift;
    if(input < drift){
      return 0;
    }
    else{
      return (input-drift)/normailize;
    }
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
