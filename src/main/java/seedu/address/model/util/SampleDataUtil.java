package seedu.address.model.util;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.Date;
import seedu.address.model.appointment.EndTime;
import seedu.address.model.appointment.Location;
import seedu.address.model.appointment.PersonName;
import seedu.address.model.appointment.StartTime;
import seedu.address.model.appointment.exceptions.ClashingAppointmentException;
import seedu.address.model.appointment.exceptions.DuplicateAppointmentException;
import seedu.address.model.person.Address;
import seedu.address.model.person.DateAdded;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), new DateAdded("02/02/2018"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new DateAdded("03/01/2018"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new DateAdded("15/02/2018"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new DateAdded("01/03/2018"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), new DateAdded("31/08/2017"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), new DateAdded("25/10/2017"),
                getTagSet("colleagues"))
        };
    }

    public static Appointment[] getSampleAppointments() {
        return new Appointment[] {
            new Appointment(new PersonName("Alex Yeoh"), new Date("15/03/2018"), new StartTime("10:30"),
                    new EndTime("11:30"), new Location("Kent Ridge MRT")),
            new Appointment(new PersonName("Bernice Yu"), new Date("25/03/2018"), new StartTime("10:30"),
                    new EndTime("11:30"), new Location("Buona Vista MRT")),
            new Appointment(new PersonName("Charlotte Oliveiro"), new Date("31/03/2018"), new StartTime("10:30"),
                    new EndTime("11:30"), new Location("Bukit Panjang MRT")),
            new Appointment(new PersonName("David Li"), new Date("01/04/2018"), new StartTime("10:30"),
                    new EndTime("11:30"), new Location("Beauty World MRT")),
            new Appointment(new PersonName("Irfan Ibrahim"), new Date("02/04/2018"), new StartTime("10:30"),
                    new EndTime("11:30"), new Location("Paya Lebar MRT")),
            new Appointment(new PersonName("Roy Balakrishnan"), new Date("03/04/2018"), new StartTime("10:30"),
                    new EndTime("11:30"), new Location("Bugis MRT")),

        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        try {
            AddressBook sampleAb = new AddressBook();
            for (Person samplePerson : getSamplePersons()) {
                sampleAb.addPerson(samplePerson);
            }
            for (Appointment sampleAppointment : getSampleAppointments()) {
                sampleAb.addAppointment(sampleAppointment);
            }
            return sampleAb;
        } catch (DuplicatePersonException e) {
            throw new AssertionError("sample data cannot contain duplicate persons", e);
        } catch (DuplicateAppointmentException e) {
            throw new AssertionError("sample data cannot contain duplicate appointments", e);
        } catch (ClashingAppointmentException e) {
            throw new AssertionError("sample data cannot contain clashing appointments", e);
        }
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        HashSet<Tag> tags = new HashSet<>();
        for (String s : strings) {
            tags.add(new Tag(s));
        }

        return tags;
    }

}
