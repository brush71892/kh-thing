package frc.robot.subsystems.intake;

public interface IntakeIO {
    // ok
    default void updateInputs(intakeiothings intakeiothings) {}

    public static class intakeiothings{
        public double rightVelocityRadPerSec = 0.0;

        public double leftVelocityRadPerSec = 0.0;

        public double driveVelocityRadPerSec = 0.0;
    }

    default void setPosition(double position) {}

    default void setSpeed(double speed) {}

    default void setWheelSpeed(double speed) {}
}
