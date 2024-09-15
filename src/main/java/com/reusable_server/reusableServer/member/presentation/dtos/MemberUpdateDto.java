qpackage com.reusable_server.reusableServer.member.presentation.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MemberUpdateDto(@NotNull Long id,
							  @Size(min = 2, max = 50) String name,
							  @Email String email,
							  @Size(min = 8, max = 30) String password) {
}

















