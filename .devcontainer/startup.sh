sed -i 's/codespaces/agnoster/' ~/.zshrc && \
sed -i'' -r -e "/prompt_hg/a\  prompt_newline" ~/.oh-my-zsh/themes/agnoster.zsh-theme && \
# cp .devcontainer/.ssh/id_rsa* ~/.ssh/ && \
echo $(pwd) && \
ssh -T git@github.com && \
git config push.recurseSubmodules check && \
git config push.recurseSubmodules on-demand && \
./gradlew clean && \ 
./gradlew build --refresh-dependencies && \
echo DONE