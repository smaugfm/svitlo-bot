package com.github.smaugfm.power.tracker.interaction.telegram

import com.github.smaugfm.power.tracker.NoLiquibaseTestBase
import com.github.smaugfm.power.tracker.EventType
import com.github.smaugfm.power.tracker.stats.EventStats
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.Duration

class TelegramMessageCreatorTest : NoLiquibaseTestBase() {

    @Autowired
    private lateinit var creator: TelegramMessageCreator

    @Test
    fun getTelegramMessages() {
        println(
            creator.getTelegramMessage(
                listOf(
                    EventStats.Single.LastInverseOnly(
                        false,
                        EventType.POWER,
                        Duration.ofDays(3)
                            .plusHours(21)
                            .plusMinutes(11)
                            .plusSeconds(59)
                            .plusMillis(342)
                    )
                )
            )
        )
        println(
            creator.getTelegramMessage(
                listOf(
                    EventStats.Single.LastInverseOnly(
                        true,
                        EventType.ISP,
                        Duration.ofDays(3)
                            .plusHours(21)
                            .plusMinutes(11)
                            .plusSeconds(59)
                            .plusMillis(342)
                    )
                )
            )
        )
        println(
            creator.getTelegramMessage(
                listOf(
                    EventStats.Single.IspDownStats(
                        Duration.ofDays(3)
                            .plusHours(21)
                            .plusMinutes(11)
                            .plusSeconds(59)
                            .plusMillis(342),
                        Duration.ofDays(3)
                            .plusHours(21)
                            .plusMinutes(11)
                            .plusSeconds(59)
                            .plusMillis(342),
                        Duration.ofDays(3)
                            .plusHours(21)
                            .plusMinutes(11)
                            .plusSeconds(59)
                            .plusMillis(342),
                    )
                )
            )
        )
    }
}
