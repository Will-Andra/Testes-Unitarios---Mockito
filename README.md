# Testes-Unitarios (Mockito)
App de Estudo de Testes Unitários com dados Mock, consumindo dados da API DummyJSON + MVVM e Clean Architecture.

# 🚀 Android Architecture & Testing Showcase

Um projeto direto ao ponto que demonstra como estruturar um aplicativo Android nativo utilizando o que há de mais moderno e adotado pelo mercado: **Clean Architecture**, **MVVM** e uma suíte robusta de **Testes Unitários com Mockito**.

---

## ⚡ O que este projeto resolve?

* **Desacoplamento Total:** A regra de negócio não sabe (e não se importa) que a API utiliza Retrofit.
* **Isolamento de Camadas:** Testes totalmente independentes de rede ou emulador, isolando comportamento de *UseCases*, *Repositories* e *ViewModels*.
* **Manutenibilidade e Testabilidade:** Mapeamento claro entre DTOs de dados e Modelos de Domínio, facilitando a criação de cenários de teste reais e legíveis.

---

## 🧠 Arquitetura e Mapeamento dos Testes

O projeto divide a produção (`main`) e os testes (`test`) de forma perfeitamente espelhada, garantindo cobertura e clareza:

| Camada | 📦 Produção (`main`) | 🧪 Testes (`test`) | Papel Estratégico |
| --- | --- | --- | --- |
| **Data** | `DummyAPIService`, `UsuarioRepositoryImpl` | `UsuarioRepositoryImplTest`, `UserDTOTestHelper` | Consumo de rede, mapeamento de DTOs para Domain e mocks das respostas da API. |
| **Domain** | `Usuario`, `GetUsuarioUseCase` | `GetUsuarioUseCaseTest` | Regras de negócio puras (ex: filtros de dados) isoladas de frameworks do Android. |
| **Presentation** | `MainActivity`, `UsuarioViewModel` | `UsuarioViewModelTest` | Gerenciamento de estado e observação síncrona de `LiveData`. |

---

## 🧪 A Estratégia dos Testes (O Diferencial)

Diferente de abordagens baseadas apenas em dublês manuais, este projeto adota **Mockito + Coroutines Test** para garantir flexibilidade e fidelidade ao mercado:

* **Mocks Dinâmicos com Mockito:** Simulação precisa de chamadas de API (`Response.success`, falhas) e comportamento de repositórios usando `@Mock` e `Mockito.when()`.
* **Data Helpers Customizados:** Uso do `UserDTOTestHelper` para criação limpa de payloads falsos (DTOs), mantendo o código dos testes legível e sem repetição.
* **Corrotinas Assíncronas:** Testes executados com `runTest` para controle exato de fluxos assíncronos em tempo de execução.
* **Asserções Elegantes com Google Truth:** Validação declarativa de fluxos e dados postados no `LiveData` através de utilitários como `getOrAwaitValue()`.

---

## 🛠️ Stack Tecnológica

* **Linguagem:** Kotlin
* **Arquitetura:** Clean Architecture + MVVM
* **Rede:** Retrofit
* **Assincronismo:** Kotlin Coroutines
* **Frameworks de Teste:** JUnit4, Mockito (`MockitoJUnitRunner`), Google Truth e Coroutines Test (`runTest`)

---

## 🏃‍♂️ Executando em 2 Passos

1. **Clone e Abra:** Abra o diretório no seu Android Studio.
2. **Rode os Testes:** Clique com o botão direito na pasta `src/test/java` e selecione **Run 'Tests in...'** para rodar a suíte completa com Mockito.

---

<img width="350" height="613" alt="image" src="https://github.com/user-attachments/assets/71b0fe99-f7bc-4fcb-af0f-b7965d17b2f9" />
<img width="350" height="613" alt="image" src="https://github.com/user-attachments/assets/58ae8880-5dd6-476a-b16a-6af1ada2e2c3" />
<img width="350" height="370" alt="image" src="https://github.com/user-attachments/assets/5f0337fa-68ad-4fb7-96c5-05ca3811c3f7" />



