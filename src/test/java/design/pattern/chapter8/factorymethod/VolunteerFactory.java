package design.pattern.chapter8.factorymethod;

/**
 * Created by h on 2017/9/24.
 */
public class VolunteerFactory implements IFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}
