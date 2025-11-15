import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.cors.CorsConfigurationSource
import java.util.Arrays


@Configuration
class CorsConfig {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuracao = CorsConfiguration()

        // IMPORTANTE: Adicionar o domínio do Vercel
        configuracao.allowedOrigins = Arrays.asList(
            "http://localhost:5173",
            "https://seu-projeto.vercel.app" // Você vai pegar essa URL depois
        )
        configuracao.allowedMethods = Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")
        configuracao.allowedHeaders = Arrays.asList("*")
        configuracao.allowCredentials = true // ADICIONAR ESTA LINHA

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuracao)

        return source
    }
}

