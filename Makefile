no-default:
	@echo "no default target"

github:
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: no-default github
