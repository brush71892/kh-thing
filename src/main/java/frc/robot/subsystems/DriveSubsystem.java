// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import static frc.robot.Constants.DriveConstants.*;

public class DriveSubsystem extends SubsystemBase {

  // declare sparkmax and sparkmaxconfig and the follow drive

  private final SparkMax sparkmax;
  private final SparkMax sparkmax2;

  private final SparkMaxConfig sparkMaxConfig;
  private final SparkMaxConfig sparkMaxConfig2;

  private final DifferentialDrive drive;

  /** Used a template to create a new drive subsystem */
  public DriveSubsystem() {

    // make brushed motors in sparkmaxes, spark1,2 are the ids and make drive
    sparkmax = new SparkMax(spark1, MotorType.kBrushed);
    sparkmax2 = new SparkMax(spark2, MotorType.kBrushed);
    
    drive = new DifferentialDrive(sparkmax, sparkmax2);
    
    // Makes new spark config objects
    sparkMaxConfig = new SparkMaxConfig();
    sparkMaxConfig2 = new SparkMaxConfig();

    // inverts the right side so that it doesnt spin around in a circle
    sparkMaxConfig2.inverted(true);

    // Disables the follower mode on both spark objects
    sparkMaxConfig.disableFollowerMode();
    sparkMaxConfig2.disableFollowerMode();

    // configures sparkmax 
    sparkmax.configure(sparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    sparkmax2.configure(sparkMaxConfig2, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public Command driveAndStop(double speed, double rotation) {
    return Commands.runEnd(
      () -> arcadeDrive(speed,rotation), 
      () -> arcadeDrive(0,0), this
      );
  }

  public Command drive(double speed, double rotation) {
    return Commands.run(() -> arcadeDrive(speed, rotation), this);
  }

  public Command stop() {
    return Commands.run(() -> arcadeDrive(0,0), this);
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}

  
  private void arcadeDrive(double speed, double rotation) {
    // drive with the x and the y from the controller 
    drive.arcadeDrive(speed, rotation, true);
  }
}