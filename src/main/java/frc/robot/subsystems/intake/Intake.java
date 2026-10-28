
package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class Intake extends SubsystemBase {
  // make intake io
  public final IntakeIO intakeio;
  
  public Intake(IntakeIO intakeio) {
    this.intakeio=intakeio;
  }

  public Command goforward() {
    return Commands.run(
      ()->intakeio.setPosition(IntakeConstants.extendedPosition),
      this);
  }

  public Command gobacktostart() {
    return Commands.run(
      ()->intakeio.setPosition(0.0),
      this);
  }

  public Command getbacktowork() {
    return Commands.runEnd(
      ()->intakeio.setWheelSpeed(IntakeConstants.workSpeed), 
      ()->intakeio.setWheelSpeed(0.0), 
      this);
  }

  @Override
  public void periodic() {
    
  }
}
