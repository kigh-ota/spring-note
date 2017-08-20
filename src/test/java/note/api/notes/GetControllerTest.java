package note.api.notes;

import com.google.common.collect.ImmutableList;
import note.NoteUtil;
import note.api.NoteResource;
import note.application.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class GetControllerTest {

    @InjectMocks
    private GetController sut;

    @Mock
    private NoteService noteServiceMock;

    @Test
    public void get() {
        doReturn(ImmutableList.of(
                NoteUtil.createNote(1, "T1", "B1", new Timestamp(1), new Timestamp(101)),
                NoteUtil.createNote(2, "T2", "B2", new Timestamp(2), new Timestamp(102))
        )).when(noteServiceMock).getAll();

        List<NoteResource> actual = sut.get();

        assertThat(actual, hasSize(2));
        assertThat(actual.get(0).getId(), is("1"));
        assertThat(actual.get(0).getTitle(), is("T1"));
        assertThat(actual.get(0).getBody(), is("B1"));
        assertThat(actual.get(0).getCreatedAt(), is(new Timestamp(1)));
        assertThat(actual.get(0).getUpdatedAt(), is(new Timestamp(101)));
        assertThat(actual.get(1).getId(), is("2"));
        assertThat(actual.get(1).getTitle(), is("T2"));
        assertThat(actual.get(1).getBody(), is("B2"));
        assertThat(actual.get(1).getCreatedAt(), is(new Timestamp(2)));
        assertThat(actual.get(1).getUpdatedAt(), is(new Timestamp(102)));

    }

}