package note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO: setup CircleCI
// TODO: search notes by a tag
// TODO: handle URIs in note body
// TODO: link among notes
// TODO: deploy
// TODO: full text search
@SpringBootApplication
public class NoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);
	}
}
