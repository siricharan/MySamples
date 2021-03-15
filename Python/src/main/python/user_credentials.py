from jproperties import Properties


class user_credentials:
    configs = None;

    def __init__(self):
        self.configs = Properties()
        with open('user.properties', 'rb') as config_file:
            self.configs.load(config_file)

    def get_user_name(self):
        return self.configs.get("user_name").data

    def get_user_pwd(self):
        return self.configs.get("user_pwd").data


if __name__ == '__main__':
    obj = user_credentials()
    obj.getusername()
    obj.get_user_pwd()
