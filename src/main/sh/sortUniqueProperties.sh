#!/usr/bin/env bash
prompt(){
    local promptText="${1}"
    local enteredResult="${2}"
    local defaultResult="${3}"
    local promptText="$(echo ${promptText} | sed "s/\s*\:*\s*$//")"
    [[ -z "${defaultResult}" ]] && promptText="${promptText}: " || promptText="${promptText} [${defaultResult}]: "
    local result="${enteredResult}"
    while [[ -z "${result}" ]] ; do
        read -p "${promptText}" result
        if [[ -z "${result}" && -n "${defaultResult}" ]] ; then
            result="${defaultResult}"
        fi
    done
    echo "${result}"
}
if [[ -z "${1}" ]]; then
    ls -1 *.properties
    fileName=$(prompt "Enter properties file: " "" "$(ls -1 *.properties 2>/dev/null | head -1)")
else
    fileName="${1}"
fi
sort -u "${fileName}" | tee temp.txt
mv temp.txt "${fileName}"
