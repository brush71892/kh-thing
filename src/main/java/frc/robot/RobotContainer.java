// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import static frc.robot.Constants.OperatorConstants.*;

import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.IntakeConstants;
import frc.robot.subsystems.intake.IntakeIO;

public class RobotContainer {

  private Intake intake;

  public DriveSubsystem driveSubsystem;
  public Trigger trih;
  private final CommandXboxController driverController = new CommandXboxController(DRIVER_CONTROLLER_PORT);


  public RobotContainer() {
    driveSubsystem = new DriveSubsystem();

    configureBindings();
  }

  public void robotPeriodic() {
    configureBindings();
  }

  private void configureBindings() {

    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    driverController.x().whileTrue(driveSubsystem.drive(driverController.getRightX(), driverController.getRightY()));
    driverController.x().onFalse(driveSubsystem.stop());

    // driveSubsystem.setDefaultCommand(new Drive(driveSubsystem, driverController));
  }

  /* 
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
  }
    */
}
