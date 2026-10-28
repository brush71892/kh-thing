package frc.robot.subsystems.intake;

import static edu.wpi.first.units.Units.RadiansPerSecond;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import frc.robot.Constants.DeviceIDs;

public class IntakeIOTalonFX implements IntakeIO {
    
    public TalonFX talonfihx = new TalonFX(DeviceIDs.leftIntakePivotid);
    public TalonFX talonfihx2 = new TalonFX(DeviceIDs.rightIntakePivotid);
    public TalonFX wheelMotor = new TalonFX(DeviceIDs.intakeWheelid);

    private TalonFXConfiguration talonfihxconfihguration;
    private TalonFXConfiguration talonfihxconfihguration2;
    private TalonFXConfiguration wheelMotorConfiguration;

    public IntakeIOTalonFX() {

        talonfihxconfihguration = new TalonFXConfiguration();
        talonfihxconfihguration2 = new TalonFXConfiguration()
        .withMotorOutput(
            new MotorOutputConfigs()
                .withInverted(InvertedValue.CounterClockwise_Positive)
        );
        wheelMotorConfiguration = new TalonFXConfiguration();

        talonfihx.setPosition(0.0);
        talonfihx2.setPosition(0.0);
        talonfihx.getConfigurator().apply(talonfihxconfihguration);
        talonfihx2.getConfigurator().apply(talonfihxconfihguration2);
        wheelMotor.getConfigurator().apply(wheelMotorConfiguration);
    }

    @Override
    public void updateInputs(intakeiothings intakeioinputs) {
       
    }

    @Override
    public void setPosition(double request) {
       talonfihx.setPosition(request);
       talonfihx2.setPosition(request);
    }

    @Override
    public void setSpeed(double speed) {
        talonfihx.set(speed);
        talonfihx2.set(speed);
    }

    @Override
    public void setWheelSpeed(double speed) {
        wheelMotor.set(speed);
    }

}