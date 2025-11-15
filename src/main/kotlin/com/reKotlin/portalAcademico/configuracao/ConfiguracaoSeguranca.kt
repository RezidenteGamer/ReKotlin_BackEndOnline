import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.cors.CorsConfigurationSource


@Configuration
class CorsConfig {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuracao = CorsConfiguration()

        configuracao.allowedOrigins = listOf(
            "http://localhost:5173",
            "https://seu-projeto.vercel.app"
        )
        configuracao.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
        configuracao.allowedHeaders = listOf("*")
        configuracao.allowCredentials = true

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuracao)

        return source
    }
}
