package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.autos.Autonomous;
import frc.autos.Follower;
import frc.inputs.NavX;
import frc.inputs.Encoders;
import frc.subsystems.Drivetrain;

public class Robot extends TimedRobot {

    public static Autonomous autonomous;
    public static Follower follower;
    public static NavX navX;
    public static Encoders encoders;
    public static Drivetrain drivetrain;


    @Override
    public void robotInit() 
    {
        autonomous = new Autonomous();
        follower = new Follower();
        navX = new NavX();
        encoders = new Encoders();
        drivetrain = new Drivetrain();
    }

    @Override
    public void robotPeriodic() 
    {
        navX.updateAHRS();
        encoders.updateEncoders();
        //encoders.testEncoders();
        drivetrain.testSpeed();
    }
    
    @Override
    public void autonomousInit() 
    {
        //follower.setupFollower();
    }

    @Override
    public void autonomousPeriodic()
    {
        autonomous.runAutonomous();
    }

    @Override
    public void teleopInit() { }

    @Override
    public void teleopPeriodic()
    {
        drivetrain.sigmaDrive(IO.leftAnalogY, IO.rightAnalogY);
        IO.ProcessControllers();
    }

    @Override
    public void testInit() { }

    @Override
    public void testPeriodic() { }
}