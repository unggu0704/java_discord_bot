package Bot.features.Functions;

import Bot.chatBot.Message.Print.Print;
import Bot.data.UserRepository;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.concurrent.TimeUnit;

/**
 * userName의 유저를 Ban 하는 메서드
 * Member 객체는 getMemberByName()로 받아온다.
 */
@Slf4j
public class Ban {

    public static void killMember(UserRepository userRepository, TextChannel tc, Guild guild, String userName) {
        Member banMember = userRepository.getMemberByName(guild, userName);
        if (banMember == null) {
            Print.showMessage(tc, "밴 할 유저를 찾을수가 없습니다.");
            return;
        }
        
        guild.ban(banMember, 600, TimeUnit.SECONDS).queue();
        log.info("ban 실행");
        Print.showMessage(tc, userName + "을 죽였습니다!");
    }

}
