# Guia de Trabalho em Equipe com Git

## Configuração Inicial (Todos precisam fazer)

### 1. Configurar Git (se ainda não fizeram)
```bash
git config --global user.name "Seu Nome"
git config --global user.email "seu.email@exemplo.com"
```

### 2. Clonar o repositório
```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

## Abordagem 1: Trabalhando com Branches (Recomendado)

### Para cada nova atividade/issue:

**1. Atualizar o repositório local**
```bash
git checkout main
git pull origin main
```

**2. Criar uma nova branch para a atividade**
```bash
git checkout -b feature/nome-da-atividade
# Exemplo: git checkout -b feature/login-page
```

**3. Fazer as alterações no código**
- Trabalhar normalmente nos arquivos
- Testar o código

**4. Adicionar e commitar as mudanças**
```bash
git add .
git commit -m "Implementa funcionalidade X - closes #numero-da-issue"
```

**5. Enviar a branch para o GitHub**
```bash
git push origin feature/nome-da-atividade
```

**6. Criar Pull Request no GitHub**
- Ir no repositório no GitHub
- Clicar em "Compare & pull request"
- Descrever as mudanças
- Solicitar review dos colegas

**7. Após aprovação, fazer merge**
- Vocês podem fazer merge pelo GitHub
- Depois deletar a branch remota

**8. Limpar branch local**
```bash
git checkout main
git pull origin main
git branch -d feature/nome-da-atividade
```

## Comandos Úteis para o Dia a Dia

### Verificar status do repositório
```bash
git status
```

### Ver histórico de commits
```bash
git log --oneline
```

### Ver diferenças antes de commitar
```bash
git diff
```

### Desfazer mudanças não commitadas
```bash
git checkout -- nome-do-arquivo
```

### Ver branches existentes
```bash
git branch -a
```

## Fluxo de Trabalho Recomendado

1. **Sempre começar atualizando**: `git pull origin main`
2. **Criar branch específica** para cada issue/atividade
3. **Commits pequenos e frequentes** com mensagens descritivas
4. **Testar antes de fazer push**
5. **Usar Pull Requests** para review de código
6. **Deletar branches** após merge

## Dicas Importantes

- **Nunca trabalhem no mesmo arquivo simultaneamente** sem coordenação
- **Façam commits pequenos** e com mensagens claras
- **Testem o código** antes de fazer push
- **Comuniquem-se** sobre quem está trabalhando em quê
- **Referenciem as issues** nos commits (ex: "closes #5")

## Resolução de Conflitos

Se aparecer conflito durante o merge:
```bash
git status  # ver quais arquivos têm conflito
# Editar os arquivos manualmente
git add arquivo-resolvido
git commit -m "Resolve conflito em arquivo X"
```

## Convenções de Nomenclatura

### Branches
- `feature/nome-da-funcionalidade` - para novas funcionalidades
- `bugfix/nome-do-bug` - para correções de bugs
- `hotfix/nome-do-hotfix` - para correções urgentes

### Commits
- Use verbos no imperativo: "Adiciona", "Remove", "Corrige"
- Seja específico: "Adiciona validação de email no formulário de login"
- Referencie issues: "Corrige bug no cálculo - closes #12"

## Exemplo Prático

Imagine que você vai implementar a funcionalidade de login:

```bash
# 1. Atualizar main
git checkout main
git pull origin main

# 2. Criar branch
git checkout -b feature/sistema-login

# 3. Fazer alterações nos arquivos...

# 4. Commitar
git add .
git commit -m "Adiciona página de login com validação - closes #3"

# 5. Enviar para GitHub
git push origin feature/sistema-login

# 6. Criar Pull Request no GitHub

# 7. Após merge, limpar
git checkout main
git pull origin main
git branch -d feature/sistema-login
```

## Troubleshooting

### Erro: "Your branch is behind"
```bash
git pull origin main
```

### Erro: "Please commit your changes"
```bash
git add .
git commit -m "WIP: salvando trabalho em progresso"
```

### Recuperar branch deletada acidentalmente
```bash
git reflog
git checkout -b nome-da-branch hash-do-commit
```

---

**Lembre-se**: Comunicação é fundamental! Sempre avisem no grupo quando estiverem trabalhando em algo específico.
