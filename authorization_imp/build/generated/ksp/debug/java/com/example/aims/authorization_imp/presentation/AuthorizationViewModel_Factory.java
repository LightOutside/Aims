package com.example.aims.authorization_imp.presentation;

import com.example.aims.authorization_imp.domain.LoginUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class AuthorizationViewModel_Factory implements Factory<AuthorizationViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  public AuthorizationViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
  }

  @Override
  public AuthorizationViewModel get() {
    return newInstance(loginUseCaseProvider.get());
  }

  public static AuthorizationViewModel_Factory create(Provider<LoginUseCase> loginUseCaseProvider) {
    return new AuthorizationViewModel_Factory(loginUseCaseProvider);
  }

  public static AuthorizationViewModel newInstance(LoginUseCase loginUseCase) {
    return new AuthorizationViewModel(loginUseCase);
  }
}
