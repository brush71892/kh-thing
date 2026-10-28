// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Drive extends Command {

  /* 

  private DriveSubsystem driveSubsystem;
  private CommandXboxController commandXboxController;

  // constructor 
  public Drive(DriveSubsystem driveSubsystem, CommandXboxController commandXboxController) {

    addRequirements(driveSubsystem);

    this.driveSubsystem = driveSubsystem;
    this.commandXboxController = commandXboxController;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    // drives the robot from the controller movements
    driveSubsystem.arcadeDrive(commandXboxController.getLeftX(), commandXboxController.getRightX());
  }

  @Override
  public void end(boolean interrupted) {
    // stops the drive
    driveSubsystem.arcadeDrive(0,0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  */
}
